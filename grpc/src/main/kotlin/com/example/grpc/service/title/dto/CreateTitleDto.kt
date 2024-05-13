package com.example.grpc.service.title.dto

import com.example.proto.title.CreateTitleRequest
import com.example.proto.title.descriptionOrNull

data class CreateTitleDto(
    val subject: String,
    val description: String? = null,
    val titleGroupId: Int,
    val createdBy: Int,
) {
    companion object {
        fun of(createTitleRequest: CreateTitleRequest): CreateTitleDto {
            return with(createTitleRequest) {
                CreateTitleDto(
                    subject = subject,
                    description = descriptionOrNull?.value,
                    titleGroupId = titleGroupId,
                    createdBy = createdBy
                )
            }
        }
    }
}