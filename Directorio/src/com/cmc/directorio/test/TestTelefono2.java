package com.cmc.directorio.test;
import com.cmc.directorio.entidades.*;

public class TestTelefono2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi", "098234234", 20, false);
        AdminTelefono at = new AdminTelefono();
        at.activarMensajeria(telf);
        System.out.println(telf);
	}

}
