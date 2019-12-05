package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Room;
import com.ftn.isa.dto.request.RoomCreateRequest;
import com.ftn.isa.dto.response.RoomResponse;
import com.ftn.isa.repository.IRoomRepository;
import com.ftn.isa.service.IRoomService;
import org.omg.CORBA.IRObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {

    private IRoomRepository _roomRepository;

    public RoomService(IRoomRepository roomRepository){ _roomRepository = roomRepository; }

    @Override
    public RoomResponse getRoomById(Long id) {
        Room room = _roomRepository.findOneById(id);
        // TODO: Throw exception in next iteration
        if (room == null) {
            return null;
        }

        return mapToResponse(room);
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        List<Room> roomList = _roomRepository.findAll();

        return roomList.stream().map(room -> mapToResponse(room)).collect(Collectors.toList());
    }

    @Override
    public RoomResponse createRoom(RoomCreateRequest request) {
        Room room = mapFromRequest(request);
        Room savedRoom = _roomRepository.save(room);

        //kako da proverim ako vec postoji isti
        //hoce li to za mene uraditi unique???

        return mapToResponse(savedRoom);
    }

    @Override
    public RoomResponse updateRoomById(RoomCreateRequest request, Long id) {
        Room room = _roomRepository.findOneById(id);

        // TODO: Throw exception in next iteration
        if (room == null) {
            return null;
        }

        Room roomForUpdate = updateRoom(room, request);

        Room savedDoctor = _roomRepository.save(roomForUpdate);

        return mapToResponse(savedDoctor);
    }

    private Room updateRoom(Room room, RoomCreateRequest request) {

        if (request.getName() != null) {
            room.setName(request.getName());
        }

        if (request.getClinic() != null) {
            room.setClinic(request.getClinic());
        }
        return room;
    }

    private RoomResponse mapToResponse(Room room){
        RoomResponse response = new RoomResponse();
        response.setId(room.getId());
        response.setName(room.getName());
        response.setClinic(room.getClinic());
        return response;
    }

    private Room mapFromRequest(RoomCreateRequest request){
        Room room = new Room();
        room.setName(request.getName());
        room.setClinic(request.getClinic());
        return room;
    }
}
