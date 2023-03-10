var botonAgregarHorario = document.getElementById("agregar-horario");
var contenedorHorarios = document.getElementById("horario");
var contenedorHorariosAgregados = document.getElementById("horarios-agregados");
var horarios = {}; // objeto para guardar los horarios agregados
var diasSeleccionados = []; // array para guardar los días seleccionados
var diaAnterior = document.getElementById("dias").value;
var horariosDiaAnterior = horarios[diaAnterior];

botonAgregarHorario.addEventListener("click", function() {
    var nuevoHorario = document.createElement("div");
    nuevoHorario.innerHTML =
    '<input type="time" id= "desde" name="desde" > <input type="time" id="hasta" name="hasta"> <button type="button" class="eliminar-horario">Eliminar horario</button>';
    contenedorHorarios.appendChild(nuevoHorario);
});

// controlador de evento para eliminar horarios
contenedorHorarios.addEventListener("click", function(evento) {
    if (evento.target.classList.contains("eliminar-horario")) {
        evento.target.parentElement.remove();
    }
});

// controlador de evento para agregar otro día                        
var botonAgregarDia = document.getElementById("agregar-dia");
botonAgregarDia.addEventListener("click", function() {
    // guardar los horarios del día anterior en el objeto 'horarios'
    var diaAnterior = document.getElementById("dias").value;
    var horariosDiaAnterior = document.querySelectorAll('div h2:contains("' + diaAnterior + '") + .contenedor-horarios input');
    if (horariosDiaAnterior.length > 0) {
        if (!horarios[diaAnterior]) {
            horarios[diaAnterior] = [];
        }
        for (var i = 0; i < horariosDiaAnterior.length; i += 2) {
            var horaDesde = horariosDiaAnterior[i].value;
            var horaHasta = horariosDiaAnterior[i + 1].value;
            horarios[diaAnterior].push({ horaDesde: horaDesde, horaHasta: horaHasta });
        }
    }

  // mostrar los horarios del día anterior en el contenedor de horarios agregados
  if (horariosDiaAnterior.length > 0) {
        var nuevoDiaAnterior = document.createElement("div");
        nuevoDiaAnterior.innerHTML =
        '<h2>' +
        diaAnterior +
        '</h2><div class="contenedor-horarios"></div>';
        contenedorHorariosAgregados.appendChild(nuevoDiaAnterior);
        var contenedorHorariosDiaAnterior = nuevoDiaAnterior.querySelector('.contenedor-horarios');
        for (var i = 0; i < horariosDiaAnterior.length; i += 2) {
            var horaDesde = horariosDiaAnterior[i].value;
            var horaHasta = horariosDiaAnterior[i + 1].value;
            var nuevoHorario = document.createElement("p");
            nuevoHorario.innerHTML = horaDesde + " - " + horaHasta;
            contenedorHorariosDiaAnterior.appendChild(nuevoHorario);
        }
    }


    // Mostrar los horarios del día seleccionado
    var diaSeleccionado = document.getElementById("dias").value;
    var horariosDiaSeleccionado = horarios[diaSeleccionado];
    var contenedorHorariosDiaSeleccionado = document.querySelector('div h2:contains("' + diaSeleccionado + '") + .contenedor-horarios');
    contenedorHorariosDiaSeleccionado.innerHTML = "";
    if (horariosDiaSeleccionado && horariosDiaSeleccionado.length > 0) {
        horariosDiaSeleccionado.forEach(function(horario) {
          var nuevoHorario = document.createElement("p");
          nuevoHorario.innerHTML = horario.horaDesde + " - " + horario.horaHasta;
          contenedorHorariosDiaSeleccionado.appendChild(nuevoHorario);
        });
    }

      

    // guardar los horarios del día actual en el objeto 'horarios'
    var diaSeleccionado = document.getElementById("dias").value;
    var horariosDiaActual = document.querySelectorAll('div h2:contains("' + diaSeleccionado + '") + .contenedor-horarios input');
    if (horariosDiaActual.length > 0) {
        if (!horarios[diaSeleccionado]) {
                horarios[diaSeleccionado] = [];
        }
        for (var i = 0; i < horariosDiaActual.length; i += 2) {
            var horaDesde = horariosDiaActual[i].value;
            var horaHasta = horariosDiaActual[i + 1].value;
            horarios[diaSeleccionado].push({ horaDesde: horaDesde, horaHasta: horaHasta });
        }
    }

   // mostrar los horarios del día actual en el contenedor de horarios agregados
    var contenedorHorariosDiaActual = document.querySelector('div h2:contains("' + diaSeleccionado + '") + .contenedor-horarios');
    contenedorHorariosDiaActual.innerHTML = "";
    horarios[diaSeleccionado].forEach(function(horario) {
        var nuevoHorario = document.createElement("p");
        nuevoHorario.innerHTML = horario.horaDesde + " - " + horario.horaHasta;
        contenedorHorariosDiaActual.appendChild(nuevoHorario);
    });

    // limpiar el formulario y mostrar los horarios del día actual
        contenedorHorarios.innerHTML = "";
        var contenedorHorariosDiaActual = document.querySelector('div h2:contains("' + diaSeleccionado + '")').nextElementSibling;
        contenedorHorariosDiaActual.innerHTML = "";
        horarios[diaSeleccionado].forEach(function(horario) {
            var nuevoHorario = document.createElement("p");
            nuevoHorario.innerHTML = horario.horaDesde + " - " + horario.horaHasta;
            contenedorHorariosDiaActual.appendChild(nuevoHorario);
        });

        // mostrar los horarios agregados de todos los días
        var horariosGuardados = Object.entries(horarios);
        var textoHorarios = "";
        horariosGuardados.forEach(function(dia) {
            textoHorarios += "<p>" + dia[0] + "</p>";
            dia[1].forEach(function(horario) {
            textoHorarios += "<p>" + horario.horaDesde + " - " + horario.horaHasta + "</p>";
        });
});
 
document.getElementById("horarios-agregados").innerHTML = textoHorarios;

// guardar los horarios en un campo oculto para enviarlos con el formulario
var horariosJSON = JSON.stringify(horarios);
document.getElementById("horarios-json").value = horariosJSON;

// limpiar los campos de horarios para el siguiente día
contenedorHorarios.innerHTML = "";

// resetear el valor del selector de días para evitar seleccionar el mismo día dos veces
document.getElementById("dias").value = "";
});

var botonFinalizar = document.getElementById("finalizar");
botonFinalizar.addEventListener("click", function() {
    // mostrar mensaje de éxito
    var mensajeExito = document.getElementById("mensaje-exito");
    mensajeExito.style.display = "block";
});

 document.addEventListener("DOMContentLoaded", function(event) {
    var agregarHorarioBtn = document.querySelector("#agregar-horario");
    agregarHorarioBtn.addEventListener("click", agregarHorario);
                            
    var agregarDiaBtn = document.querySelector("#agregar-dia");
    agregarDiaBtn.addEventListener("click", agregarDia);
                            
    var finalizarBtn = document.querySelector("#finalizar");
    finalizarBtn.addEventListener("click", finalizar);
    });
                            
function agregarHorario() {
    var diaSeleccionado = document.getElementById("dias").value;
    var horariosSeleccionados = document.getElementById("horarios-seleccionados");
    var horarioDiv = document.createElement("div");
    horarioDiv.classList.add("horario-seleccionado");
                            
    var diaSeleccionadoP = document.createElement("p");
    diaSeleccionadoP.textContent = diaSeleccionado;
    horarioDiv.appendChild(diaSeleccionadoP);
                            
    var desdeSeleccionadoP = document.createElement("p");
    desdeSeleccionadoP.textContent = document.getElementById("desde").value;
    horarioDiv.appendChild(desdeSeleccionadoP);
                            
    var hastaSeleccionadoP = document.createElement("p");
    hastaSeleccionadoP.textContent = document.getElementById("hasta").value;
    horarioDiv.appendChild(hastaSeleccionadoP);
                            
    horariosSeleccionados.appendChild(horarioDiv);
                            
    document.getElementById("desde").value = "";
    document.getElementById("hasta").value = "";
    }
                            
    function agregarDia() {
        var dias = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"];
        var diaSeleccionado = document.getElementById("dia-select").value;
    
        if (diaSeleccionado !== "") {
            var horariosDiv = document.createElement("div");
            horariosDiv.className = "horarios";
    
            var desdeInput = document.getElementById("desde-input");
            var hastaInput = document.getElementById("hasta-input");
            var desde = desdeInput.value;
            var hasta = hastaInput.value;
    
            if (desde !== "" && hasta !== "") {
                var horarioDiv = document.createElement("div");
                horarioDiv.className = "horario-seleccionado";
                horarioDiv.innerHTML = "<p>Desde: " + desde + "</p><p>Hasta: " + hasta + "</p><button class='eliminar-horario'>Eliminar</button>";
                horariosDiv.appendChild(horarioDiv);
    
                desdeInput.value = "";
                hastaInput.value = "";
            }
    
            var diaDiv = document.createElement("div");
            diaDiv.className = "dia-seleccionado";
            diaDiv.id = "dia-seleccionado-" + (new Date()).getTime();
    
            var p = document.createElement("p");
            p.textContent = dias[diaSeleccionado] + ":";
            diaDiv.appendChild(p);
            diaDiv.appendChild(horariosDiv);
    
            var agregarHorarioButton = document.createElement("button");
            agregarHorarioButton.textContent = "Agregar otro horario";
            agregarHorarioButton.className = "agregar-horario";
            diaDiv.appendChild(agregarHorarioButton);
    
            var eliminarDiaButton = document.createElement("button");
            eliminarDiaButton.textContent = "Eliminar día";
            eliminarDiaButton.className = "eliminar-dia";
            diaDiv.appendChild(eliminarDiaButton);
    
            document.getElementById("horarios-seleccionados").appendChild(diaDiv);
    
            agregarHorarioButton.addEventListener("click", agregarHorario);
            eliminarDiaButton.addEventListener("click", eliminarDia);
        }
    }
    





                            
        function finalizar() {
            var diasSeleccionados = document.querySelectorAll(".dia-seleccionado");
            var info = "";
        
            for (var i = 0; i < diasSeleccionados.length; i++) {
                var diaSeleccionado = diasSeleccionados[i].querySelector("p").textContent;
                var horariosSeleccionados = diasSeleccionados[i].querySelectorAll(".horario-seleccionado");
                var horariosInfo = [];
        
                for (var j = 0; j < horariosSeleccionados.length; j++) {
                    var desde = horariosSeleccionados[j].querySelector("p:nth-child(2)").textContent;
                    var hasta = horariosSeleccionados[j].querySelector("p:nth-child(3)").textContent;
                    horariosInfo.push(desde + " - " + hasta);
                }
        
                if (info !== "") {
                    info += "\n";
                }
        
                info += diaSeleccionado + ": " + horariosInfo.join(", ");
            }
        
            alert(info);
        }
        

document.getElementById("agregar-horario").addEventListener("click", agregarHorario);
document.getElementById("agregar-dia").addEventListener("click", agregarDia);
document.getElementById("finalizar").addEventListener("click", finalizar);
