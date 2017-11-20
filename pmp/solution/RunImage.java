package solution;

import javax.media.jai.PlanarImage;

import Model.ResultModel;
import importclasses.Coordinate;
import importclasses.FilterCalcCentroids;
import interfaces.Writeable;
import pipes.SimplePipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class RunImage {

    String expectedCentroids = "C:/Users/Home/Desktop/Semester 5/Systemarchitektur/Übungen/Aufgabe 2/expectedCentroids.txt";

    public static void main(String[] args) throws IOException {
        int xIn;
        int yIn;
        int numberOfCentroids;
        int range;
        LinkedList<Coordinate> coordinates = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of Centroids to check:");
        numberOfCentroids = Integer.parseInt(br.readLine());
        while (numberOfCentroids > 0) {
            System.out.print("Enter x for centroidNr.: " + numberOfCentroids + ": ");
            xIn = Integer.parseInt(br.readLine());
            System.out.println("Enter y for centroidNr. " + numberOfCentroids + ": ");
            yIn = Integer.parseInt(br.readLine());
            coordinates.add(new Coordinate(xIn, yIn));
            numberOfCentroids--;
        }
        System.out.print("Enter expected range:");
        range = Integer.parseInt(br.readLine());

        ImageSink sink = new ImageSink();
        CheckDeviationFilter deviationFilter = new CheckDeviationFilter((Writeable<ResultModel>) new SimplePipe<ResultModel>(sink), coordinates, range);
        CountBallsFilter countBallsFilter = new CountBallsFilter(new SimplePipe<ResultModel>((Writeable<ResultModel>) deviationFilter));
        FilterCalcCentroids centroidsFilter = new FilterCalcCentroids(new SimplePipe<ArrayList<Coordinate>>((Writeable<ArrayList<Coordinate>>) countBallsFilter));
        DisplayFilter df5 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>(centroidsFilter), "after edFilter");
        ErodeDilateFilter edFilter = new ErodeDilateFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df5));
        ImageSaveFilter imageSaveFilter = new ImageSaveFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) edFilter));
        DisplayFilter df4 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) imageSaveFilter), "after MedianFilter");
        MedianFilter medianFilter = new MedianFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df4));
        DisplayFilter df3 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) medianFilter), "after SelectionFilter");
        SelectionFilter selectionFilter = new SelectionFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df3));
        DisplayFilter df2 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) selectionFilter), "after RoiFilter");
        RoiFilter rf = new RoiFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df2));
        DisplayFilter df1 = new DisplayFilter((Writeable<PlanarImage>) new SimplePipe<PlanarImage>((Writeable<PlanarImage>) rf), "after Source");
        //ImageSource source = new ImageSource(new SimplePipe<PlanarImage>((Writeable<PlanarImage>) df1));

        sink.setStartcoordinates(coordinates);
        sink.setrange(range);

        //source.run();
    }

}
