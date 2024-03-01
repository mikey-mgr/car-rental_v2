package com.Mike.Proj.dto.user;

public class SigninResponseDto {
    
    private String status;
    private String token;
    private String role;

    public SigninResponseDto(String status, String token, String role){
        this.status = status;
        this.token = token;
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
