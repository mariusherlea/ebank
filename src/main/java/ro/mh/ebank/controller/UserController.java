package ro.mh.ebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.mh.ebank.converter.UserConverter;
import ro.mh.ebank.dto.UserDto;
import ro.mh.ebank.model.User;
import ro.mh.ebank.repository.UserRepository;
import ro.mh.ebank.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter converter;
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        List<User> findAll = userRepository.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/find/{ID}")
    public UserDto findById(@PathVariable(value = "ID") Long id) {
        User orElse = userRepository.findById(id).orElse(null);
        return converter.entityToDto(orElse);

    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto dto) {

        User user = converter.dtoToEntity(dto);
        user = userRepository.save(user);
        return converter.entityToDto(user);
    }


    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable long id, @RequestBody UserDto userDto) {

        User user = converter.dtoToEntity(userDto);
        user = userService.updateUser(id, user);
        return converter.entityToDto(user);

    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "User deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }*/
}
