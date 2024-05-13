package com.example.grpc.service.titlegroup.dto

import com.example.proto.titlegroup.CreateTitleGroupRequest

data class CreateTitleGroupDto(
    val subject: String,
    val createdBy: Int,
) {
    companion object {
        fun of(createTitleGroupRequest: CreateTitleGroupRequest): CreateTitleGroupDto {
            return with(createTitleGroupRequest) {
                CreateTitleGroupDto(
                    subject = subject,
                    createdBy = createdBy,
                )
            }
        }
    }
}