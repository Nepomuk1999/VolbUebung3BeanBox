package interfaces;


import java.lang.Readable;

public interface IOable<in, out> extends interfaces.Readable<out>, Writeable<in> {

}
