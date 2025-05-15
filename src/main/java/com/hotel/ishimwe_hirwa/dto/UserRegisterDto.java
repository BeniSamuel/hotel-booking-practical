package com.hotel.ishimwe_hirwa.dto;

import com.hotel.ishimwe_hirwa.enums.Role;

public class UserRegisterDto {
    private String name;
    private String email;
    private String password;
    private Role role;

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public Role getRole () { return this.role; }
}
