package ru.sber.io

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream


/**
 * Реализовать методы архивации и разархивации файла.
 * Для реализиации использовать ZipInputStream и ZipOutputStream.
 */
class Archivator {


    /**
     * Метод, который архивирует файл logfile.log в архив logfile.zip.
     * Архив должен располагаться в том же каталоге, что и исходной файл.
     */
    fun zipLogfile() {
        val fileToZip = File("io\\logfile.log")
        val fos = FileOutputStream("io\\logfile.zip")
        ZipOutputStream(fos).use {
            val fis = FileInputStream(fileToZip)
            val zipEntry = ZipEntry(fileToZip.name)
            it.putNextEntry(zipEntry)
            val bytes = ByteArray(1024)

            var length: Int
            while (fis.read(bytes).also { length = it } >= 0) {
                it.write(bytes, 0, length)
            }
        }

    }

    /**
     * Метод, который извлекает файл из архива.
     * Извлечь из архива logfile.zip файл и сохарнить его в том же каталоге с именем unzippedLogfile.log
     */
    fun unzipLogfile() {
        val destDir = File("io\\unzippedLogfile.log")
        val buffer = ByteArray(1024)
        val zis = ZipInputStream(FileInputStream("io\\logfile.zip"))
        zis.nextEntry
        FileOutputStream(destDir).use {
            var len: Int
            while (zis.read(buffer).also { len = it } > 0) {
                it.write(buffer, 0, len)
            }
        }

    }
}