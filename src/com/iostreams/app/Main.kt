package com.iostreams.app

import java.io.BufferedInputStream
import java.io.DataInputStream
import java.io.FileInputStream

fun main (args: Array<String>) {
    buffereInputStreamTry()
    dataInputStreamTry()
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