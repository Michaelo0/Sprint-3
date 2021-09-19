package ru.sber.qa

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class CertificateRequestTest {

    @Test
    fun processTest() {
        val arr = Random.nextBytes(100)
        val employeeNumber = 10L
        val certificateType: CertificateType = CertificateType.NDFL
        val certReq = CertificateRequest(employeeNumber, certificateType)
        mockkObject(Scanner)
        every { Scanner.getScanData() } returns arr

        val cert = Certificate(certReq, employeeNumber, arr)

        println(cert.data)
        assertEquals(cert.data, arr)
        assertEquals(cert.processedBy, employeeNumber)
        unmockkObject(Scanner)
    }
}