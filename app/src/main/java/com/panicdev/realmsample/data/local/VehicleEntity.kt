package com.panicdev.realmsample.data.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class VehicleEntity : RealmObject {

    @PrimaryKey
    var nopol: String = ""
    var id: Long = 0
    var model: String = ""
    var warna: String = ""
    var nomor_rangka: String = ""
    var nomor_mesin: String = ""
    var tahun: String = ""
    var leasing: String = ""
    var cabang: String = ""
    var nama_penghutang: String = ""
    var sisa_hutang: String = ""
    var date: String = ""
}