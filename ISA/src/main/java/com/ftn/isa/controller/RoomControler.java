package com.ftn.isa.controller;

import com.ftn.isa.dto.request.RoomCreateRequest;
import com.ftn.isa.dto.response.RoomResponse;
import com.ftn.isa.service.IRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomControler {

    private final IRoomService _roomService;

    public RoomControler(IRoomService roomService){ _roomService = roomService;}

    @GetMapping()
    public ResponseEntity<List<RoomResponse>> getAllDoctors() {
        List<RoomResponse> response = _roomService.getAllRooms();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id) {
        RoomResponse response = _roomService.getRoomById(id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RoomResponse> createRoom(@RequestBody @Valid RoomCreateRequest request) {
        RoomResponse response = _roomService.createRoom(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@RequestBody @Valid
            RoomCreateRequest request, @PathVariable Long id) {
        RoomResponse response = _roomService.updateRoomById(request, id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
