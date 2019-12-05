package com.ftn.isa.service;

import com.ftn.isa.dto.request.RoomCreateRequest;
import com.ftn.isa.dto.response.RoomResponse;

import java.util.List;

public interface IRoomService {
    RoomResponse getRoomById(Long id);
    List<RoomResponse> getAllRooms();
    RoomResponse createRoom(RoomCreateRequest request);
    RoomResponse updateRoomById(RoomCreateRequest request, Long id);
}
