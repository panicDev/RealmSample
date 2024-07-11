package com.panicdev.realmsample.data.local

import com.panicdev.realmsample.data.utils.DomainMapper
import com.panicdev.realmsample.domain.models.Vehicle

class VehicleMapper : DomainMapper<VehicleEntity, Vehicle> {
    override fun mapToDomainModel(data: VehicleEntity): Vehicle {
        return Vehicle(
            id = data.id,
            nopol = data.nopol,
            model = data.model,
            color = data.warna,
            frameNumber = data.nomor_rangka,
            machineNumber = data.nomor_mesin,
            year = data.tahun,
            leasing = data.leasing,
            branch = data.cabang,
            debtorName = data.nama_penghutang,
            remainingDebt = data.sisa_hutang,
            date = data.date
        )
    }
}