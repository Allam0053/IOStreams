package com.iostreams.app

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.DataInputStream
import java.io.FileInputStream
import java.net.Socket

fun main (args: Array<String>) {
//    buffereInputStreamTry()
//    dataInputStreamTry()
    socketTry()
}

fun socketTry() {
    try {
        // 1. create a new socket object
        var socket:Socket = Socket("monta.if.its.ac.id", 80)

        // 2. obtain the input and output
        var bis = BufferedInputStream( socket.getInputStream() )
        var bos = BufferedOutputStream( socket.getOutputStream() )

        // 3. exchange messages
        bos.write( "Hello world\r\n\r\n".toByteArray() )
        bos.flush()

        //
        var bResp = bis.readAllBytes()
//        var bResp = bis.readNBytes( 100 )
        var resp = String( bResp )
        print( resp )

//        var resp = ""
//        while( bResp.size < 100 ) {
//            resp += bResp.toString()
//            bResp = bis.readNBytes( 100 )
//        }

//        print( resp )

        // 4. close connection
        socket.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun dataInputStreamTry () {
    try {
        val file = "C:\\developing\\project\\project-java\\IOStreams\\txt\\input.txt"
        val inputStream: FileInputStream = FileInputStream(file)
        val ioStream: DataInputStream = DataInputStream(inputStream)

        var stream: Int? = ioStream.read()
        while( stream != -1 && stream != null ) {
            print( stream?.toChar() )
            stream = ioStream.read()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun buffereInputStreamTry () {
    try {
        val file = "C:\\developing\\project\\project-java\\IOStreams\\txt\\input.txt"
        val inputStream: FileInputStream = FileInputStream(file)
        val ioStream: BufferedInputStream = BufferedInputStream(inputStream)

        var stream: Int? = ioStream.read()
        while( stream != -1 && stream != null ) {
            print( stream?.toChar() )
            stream = ioStream.read()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}