package com.example.grpc.handler.titlegroup

import com.example.grpc.service.titlegroup.dto.TitleGroupDto
import com.example.grpc.utils.toTimestamp
import com.example.proto.titlegroup.TitleGroupListResponse
import com.example.proto.titlegroup.TitleGroupResponse
import com.example.proto.titlegroup.titleGroupListResponse
import com.example.proto.titlegroup.titleGroupResponse
import com.google.protobuf.Int32Value

object TitleGroupMapper {
    fun fromTitleGroupResponse(titleGroupDto: TitleGroupDto): TitleGroupResponse {
        return titleGroupResponse {
            id = titleGroupDto.id
            subject = titleGroupDto.subject
            createdBy = titleGroupDto.createdBy
            titleGroupDto.modifiedBy?.let { modifiedBy = Int32Value.of(it) }
            createdDate = titleGroupDto.createdDate.toTimestamp()
            modifiedDate = titleGroupDto.modifiedDate.toTimestamp()
        }
    }

    fun fromTitleGroupListResponse(titleGroupDtoList: List<TitleGroupDto>): TitleGroupListResponse {
        return titleGroupListResponse {
            titleGroup.addAll(titleGroupDtoList.map { fromTitleGroupResponse(it) })
        }
    }
}