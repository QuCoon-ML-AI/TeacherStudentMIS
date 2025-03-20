//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.config

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.OutputStream
import javax.servlet.ServletOutputStream
import javax.servlet.WriteListener

class ServletOutputStreamCopier(private val outputStream: OutputStream) : ServletOutputStream() {
    private val copy: ByteArrayOutputStream = ByteArrayOutputStream(1024)

    @Throws(IOException::class)
    override fun write(b: Int) {
        outputStream.write(b)
        copy.write(b)
    }

    fun getCopy(): ByteArray {
        return copy.toByteArray()
    }

    override fun isReady(): Boolean {
        // TODO Auto-generated method stub
        return true
    }

    override fun setWriteListener(listener: WriteListener) {
        // TODO Auto-generated method stub
    }
}
