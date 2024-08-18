package br.edu.ifpe.apae.negocio;

public class FabricaControlador {
	public static IControladorPaciente getControladorPaciente() {
		return new ControladorPaciente();
	}
}