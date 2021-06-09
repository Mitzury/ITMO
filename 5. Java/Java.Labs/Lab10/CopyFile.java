package ru.mitzury;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class CopyFile
{
    public static void copyFileMethod( File from, File to ) throws IOException {

        if ( !to.exists() ) { to.createNewFile(); }

        try (
                FileChannel in = new FileInputStream( from ).getChannel();
                FileChannel out = new FileOutputStream( to ).getChannel() ) {

            out.transferFrom( in, 0, in.size() );
        }
    }


}
