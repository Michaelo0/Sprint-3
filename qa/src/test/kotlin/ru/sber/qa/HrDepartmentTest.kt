package ru.sber.qa

import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset

class HrDepartmentTest {

    private val cert1 = CertificateRequest(124L, CertificateType.NDFL)
    private val cert2 = CertificateRequest(124L, CertificateType.LABOUR_BOOK)

    @BeforeEach
    fun init() {
        mockkObject(HrDepartment)
    }

    @Test
    fun receiveRequestTest() {
        HrDepartment.clock = Clock.fixed(
            Instant.parse("2021-09-18T20:00:03Z"), ZoneOffset.UTC)

        Assertions.assertThrows(WeekendDayException().javaClass) { HrDepartment.receiveRequest(cert1) }
    }

    @Test
    fun receiveRequestIsAllowTestNDFL() {
        HrDepartment.clock = Clock.fixed(
            Instant.parse("2021-09-16T20:00:03Z"), ZoneOffset.UTC)
        Assertions.assertThrows(NotAllowReceiveRequestException().javaClass) { HrDepartment.receiveRequest(cert1) }
    }

    @Test
    fun receiveRequestIsAllowTestLABOUR_BOOK() {
        HrDepartment.clock = Clock.fixed(
            Instant.parse("2021-09-15T20:00:03Z"), ZoneOffset.UTC)
        Assertions.assertThrows(NotAllowReceiveRequestException().javaClass) { HrDepartment.receiveRequest(cert2) }
    }


}