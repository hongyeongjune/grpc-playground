package com.example.grpc.service.title.dto

import com.example.grpc.entity.title.TitleEntity
import java.time.LocalDateTime

data class TitleDto(
    val id: Int,
    val subject: String,
    val description: String? = null,
    val titleGroupId: Int,
    val createdBy: Int,
    val modifiedBy: Int? = null,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
) {
    companion object {
        fun of(titleEntity: TitleEntity): TitleDto {
            return with(titleEntity) {
                TitleDto(
                    id = id!!,
                    subject = subject,
                    description = description,
                    titleGroupId = titleGroupId,
                    createdBy = createdBy,
                    modifiedBy = modifiedBy,
                    createdDate = createdDate,
                    modifiedDate = modifiedDate,
                )
            }
        }
    }
}