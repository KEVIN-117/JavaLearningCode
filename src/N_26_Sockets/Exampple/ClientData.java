package N_26_Sockets.Exampple;

import java.io.Serializable;

public class ClientData implements Serializable {
    private String name;
    private String msg;
    private Character gender;

    public ClientData(String name, Character gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String welcomeMessage(ClientData data){
        return ((data.getGender().toString().equalsIgnoreCase("female")))? FontColors.pink+data.getName() : FontColors.azul+getName() + " envio: \n" + data.getMsg();
    }
}
