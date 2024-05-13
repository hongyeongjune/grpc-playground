package com.example.grpc.handler.title

import com.example.grpc.service.title.dto.TitleDto
import com.example.grpc.utils.toTimestamp
import com.example.proto.title.TitleListResponse
import com.example.proto.title.TitleResponse
import com.example.proto.title.titleListResponse
import com.example.proto.title.titleResponse
import com.google.protobuf.Int32Value
import com.google.protobuf.StringValue

object TitleMapper {
    fun fromTitleResponse(titleDto: TitleDto): TitleResponse {
        return titleResponse {
            id = titleDto.id
            titleGroupId = titleDto.titleGroupId
            subject = titleDto.subject
            titleDto.description?.let { description = StringValue.of(it) }
            createdBy = titleDto.createdBy
            titleDto.modifiedBy?.let { modifiedBy = Int32Value.of(it) }
            createdDate = titleDto.createdDate.toTimestamp()
            modifiedDate = titleDto.modifiedDate.toTimestamp()
        }
    }

    fun fromTitleListResponse(titleDtoList: List<TitleDto>): TitleListResponse {
        return titleListResponse {
            title.addAll(titleDtoList.map { fromTitleResponse(it) })
        }
    }
}