package ro.mh.ebank.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ro.mh.ebank.dto.UserDto;
import ro.mh.ebank.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDto entityToDto(User user) {

//		StudentDto dto = new StudentDto();
//		dto.setId(student.getId());
//		dto.setName(student.getName());
//		dto.setUsername(student.getUsername());
//		dto.setPassword(student.getPassword());
//		
//		return dto;

        ModelMapper mapper =new ModelMapper();
        UserDto map = mapper.map(user, UserDto.class);
        return map;

    }
    public  List<UserDto> entityToDto(List<User> users) {

        return	users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }


    public User dtoToEntity(UserDto dto)
    {
//		Student st = new Student();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setPassword(dto.getPassword());
//		st.setUsername(dto.getUsername());
//		
//		return st;

        ModelMapper mapper = new ModelMapper();
        User map = mapper.map(dto, User.class);
        return map;
    }

    public List<User> dtoToEntity(List<UserDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
