package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    // Ordenar el horario por hora de llegada
    // Recuperar todos los elementos de la base de datos
    @Query("SELECT * from schedule ORDER BY arrival_time ASC")
    fun getAllItems(): Flow<List<BusSchedule>>

    // Recuperar un solo elemento con el nombre de la parada de autobús
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getBusScheduleByStopName(stopName: String): Flow<List<BusSchedule>>
}