class Paciente(codigo: Int, nombre: String, apellido: String, direccion: String, telefono: String, edad: Byte) {
	var codigo: Int = codigo
	var nombre: String = nombre
	var apellido: String = apellido
	var direccion: String = direccion
	var telefono: String = telefono
	var edad: Byte = edad
}

val miPaciente = arrayListOf<Paciente>()

fun main(args: Array<String>) {
	menu()
}

fun menu() {
	var aux: String
	var opc: Int

	do {
		println("\u001Bc")

		println("Menu:")
		println("1. Insertar Paciente.")
		println("2. Mostrar.")
		println("3. Actualizar Paciente.")
		println("4. Buscar Paciente por edad.")
		println("5. Eliminar Paciente.")
		println("6. Salir.")
		println("Ingrese una opcion:")
		
		aux = readLine()!!
		if(validarIngreso(aux, 1))
			opc = aux.toInt()
		else
			opc = -1

		when (opc) {
			1 -> insertar()
			2 -> mostrar()
			3 -> actualizar()
			4 -> buscarEdad()
			5 -> eliminar()
			6 -> error("Gracias por usar...")
			else -> error("Ingrese un dato correcto.")
		}
	} while (opc != 6)
}

fun insertar() {
	println("\u001Bc")
	println("Insertar nuevo paciente:")

	var aux: String
	var auxCodigo: Int

	do {
		println("Inserte el codigo del paciente:")
		aux = readLine()!!

		if (validarIngreso(aux, 1)) {
			auxCodigo = aux.toInt()
			if (auxCodigo > 0)
				break
			else
				error("Ingrese un codigo correcto");
		} else
			error("Ingrese un codigo correcto");
	} while (true)

	if (!existePaciente(auxCodigo)) {
		println("Ingrese el nombre del paciente:")
		val auxNombre = readLine()!!
		println("Ingrese el apellido del paciente:")
		val auxApellido = readLine()!!
		println("Ingrese la direccion del paciente:")
		val auxDireccion = readLine()!!
		println("Ingrese el telefono del paciente:")
		val auxTelefono = readLine()!!
		var auxEdad: Byte
		do {
			println("Ingrese la edad del paciente:")
			aux = readLine()!!
			if (validarIngreso(aux, 0)) {
				auxEdad = aux.toByte()
				if (auxEdad > 0 && auxEdad < 100)
					break
				else
					error("Se equivoca, ingrese un dato correcto.")
			} else
				error("Se equivoca, ingrese un dato correcto.")
		} while (true)

		miPaciente.add(Paciente(auxCodigo, auxNombre, auxApellido, auxDireccion, auxTelefono, auxEdad))
		println("Paciente ingresado con exito.")
	} else
		error("Ya existe un paciente con este codigo.")
	Thread.sleep(2000)
}

fun mostrar() {
	println("\u001Bc")
	println("Mostrar los pacientes:")

	if (!miPaciente.isEmpty()) {
		for (i: Paciente in miPaciente) {
			println("---------------------------------------------")
			println("El codigo del paciente: " + i.codigo + ".")
			println("El nombre del paciente: " + i.nombre + ".")
			println("El apellido del paciente: " + i.apellido + ".")
			println("La direccion del paciente: " + i.direccion + ".")
			println("El telefono del paciente: " + i.telefono + ".")
			println("La edad del paciente: " + i.edad + ".")
			println("---------------------------------------------")
		}
		println("Presione enter para continuar")
		readLine()!!
	} else
		error("Debe ingresar un paciente primero.")

	Thread.sleep(2000)
}

fun actualizar() {
	println("\u001Bc")
	println("Actualizar un paciente:")

	if (!miPaciente.isEmpty()) {
		var opc: Int
		var aux: String
		var auxCodigo: Int

		do {
			println("Inserte el codigo del paciente que desea actualizar:")
			aux = readLine()!!
			if (validarIngreso(aux, 1)) {
				auxCodigo = aux.toInt()
				if (auxCodigo > 0)
					break
				else
					error("Ingrese un codigo correcto");
			} else
				error("Ingrese un codigo correcto");
		} while (true)

		if (existePaciente(auxCodigo)) {
			val pacienteActualizar: Paciente = buscarPaciente(auxCodigo)

			do {
				println("\u001Bc")

				println("Menu de actualizacion:")
				println("1. Nombre.")
				println("2. Apellido.")
				println("3. Direccion.")
				println("4. Telefono.")
				println("5. Edad.")
				println("6. Salir.")
				println("Ingrese una opcion:")
				aux = readLine()!!
				if(validarIngreso(aux, 1))
					opc = aux.toInt()
				else
					opc = -1

				println("\u001Bc")
				when (opc) {
					1 -> {
						println("Ingrese el nuevo nombre:")
						val auxNombre: String = readLine()!!
						pacienteActualizar.nombre = auxNombre
						println("Proceso de actualizacion con exito")
					}
					2 -> {
						println("Ingrese el nuevo apellido:")
						val auxApellido: String = readLine()!!
						pacienteActualizar.apellido = auxApellido
						println("Proceso de actualizacion con exito")
					}
					3 -> {
						println("Ingrese la nuevo direccion:")
						val auxDireccion: String = readLine()!!
						pacienteActualizar.direccion = auxDireccion
						println("Proceso de actualizacion con exito")
					}
					4 -> {
						println("Ingrese el nuevo telefono:")
						val auxTelefono: String = readLine()!!
						pacienteActualizar.telefono = auxTelefono
						println("Proceso de actualizacion con exito")
					}
					5 -> {
						var auxEdad: Byte

						do {
							println("Ingrese la nueva edad del paciente:")
							aux = readLine()!!
							if (validarIngreso(aux, 0)) {
								auxEdad = aux.toByte()
								if (auxEdad > 0 && auxEdad < 100)
									break
								else
									error("Se equivoca, ingrese un dato correcto.")
							} else
								error("Se equivoca, ingrese un dato correcto.")
						} while (true)

						pacienteActualizar.edad = auxEdad

						println("Proceso de actualizacion con exito")
					}
					6 -> println("Regresando al menu anterior...")
					else -> error("Ingrese un valor correcto.")
				}
				Thread.sleep(1000)
			} while (opc != 6)
		} else
			error("No se encontro un paciente con este codigo.")
	} else
		error("Debe ingresar un paciente primero.")

	Thread.sleep(1000)
}

fun buscarEdad() {
	println("\u001Bc")
	println("Buscar paciente por edad:")

	if (!miPaciente.isEmpty()) {
		var aux: String
		var auxEdad: Byte
		var bandera: Boolean = false

		do {
			println("Ingrese la edad del paciente:")
			aux = readLine()!!
			if (validarIngreso(aux, 0)) {
				auxEdad = aux.toByte()
				if (auxEdad > 0 && auxEdad < 100)
					break
				else
					error("Se equivoca, ingrese un dato correcto.")
			} else
				error("Se equivoca, ingrese un dato correcto.")
		} while (true)

		println("\u001Bc")

		println("Los pacientes con la edad de " + auxEdad + " son:")

		for (i: Paciente in miPaciente)
			if (i.edad == auxEdad) {
				println("---------------------------------------------")
				println("El codigo del paciente: " + i.codigo + ".")
				println("El nombre del paciente: " + i.nombre + ".")
				println("El apellido del paciente: " + i.apellido + ".")
				println("La direccion del paciente: " + i.direccion + ".")
				println("El telefono del paciente: " + i.telefono + ".")
				println("La edad del paciente: " + i.edad + ".")
				println("---------------------------------------------")

				bandera = true;
			}
		if (!bandera) 
			println("0.")
		else {
			println("Presione enter para continuar")
			readLine()!!
		}
	} else
		error("Debe ingresar un paciente primero.")
	Thread.sleep(1000)
}

fun eliminar() {
	println("\u001Bc")
	println("Eliminar un paciente:")

	if (!miPaciente.isEmpty()) {
		var aux: String
		var auxCodigo: Int

		do {
			println("Inserte el codigo del paciente que desea actualizar:")
			aux = readLine()!!
			if (validarIngreso(aux, 1)) {
				auxCodigo = aux.toInt()
				if (auxCodigo > 0)
					break
				else
					error("Ingrese un codigo correcto");
			} else
				error("Ingrese un codigo correcto");
		} while (true)

		if (existePaciente(auxCodigo)) {
			miPaciente.remove(buscarPaciente(auxCodigo))
			println("Borrado exitoso")
		} else
			error("No se encontro un paciente con este codigo.")

	} else
		error("Debe ingresar un paciente primero.")

	Thread.sleep(1000)
}

fun buscarPaciente(codigo: Int): Paciente {
	for (i: Paciente in miPaciente)
		if (i.codigo == codigo)
			return i
	return Paciente(-1, "", "", "", "", 0)
}

fun existePaciente(codigo: Int): Boolean {
	if (!miPaciente.isEmpty())
		for (i: Paciente in miPaciente)
			if (i.codigo == codigo)
				return true
	return false
}

fun error(mensaje: String) {
	println("\u001Bc")
	println(mensaje)
	Thread.sleep(1000)
	println("\u001Bc")
}

fun validarIngreso(dato: String, opc: Int): Boolean {
	try {
		if (opc == 0)
			dato.toByte()
		else if (opc == 1)
			dato.toInt()
		return true;
	} catch (e: NumberFormatException) {
		return false;
	}
}
