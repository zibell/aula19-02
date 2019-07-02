const btnSave = document.getElementById('salvar');
const fieldName = document.getElementById('nome');


$(btnSave).on('click', function () {
  var nomeCarta = fieldName.value;
  alert(nomeCarta);
  const request = {
    nomeCarta: nomeCarta
  }
  $.getJSON("http://localhost:8080/cartas?nomecarta=" + request.nomeCarta, function (response) {
    console.log(response);
  });

});

$.getJSON("http://localhost:8080/colecao", function (response) {
  console.log(response);
  const table = document.querySelector('#table')
  table.innerHTML = "";
  var t = document.createElement("table");

  var thead = document.createElement("thead");
  var tbody = document.createElement("tbody");
  var headRow = document.createElement("tr");

  ["ID", "Nome", "Custo", "CMC", "Cor", "Tipo", "Coleção"].forEach(function (el) {
    var th = document.createElement("th");
    th.appendChild(document.createTextNode(el));
    headRow.appendChild(th);
  });

  thead.appendChild(headRow);
  t.appendChild(thead);

  for (let index = 0; index < response.length; index++) {
    const element = response[index];

    var tr = document.createElement("tr")
    var td = document.createElement("td")
    var outrotd = document.createElement("td")
    var outrotd1 = document.createElement("td")
    var outrotd2 = document.createElement("td")
    var outrotd3 = document.createElement("td")
    var outrotd4 = document.createElement("td")
    var outrotd5 = document.createElement("td")
    var outrotd6 = document.createElement("td")

    td.appendChild(document.createTextNode(element.id))
    outrotd1.appendChild(document.createTextNode(element.nomeCard))
    outrotd2.appendChild(document.createTextNode(element.custoCard))
    outrotd3.appendChild(document.createTextNode(element.custoCMCCard))
    outrotd4.appendChild(document.createTextNode(element.corCard))
    outrotd5.appendChild(document.createTextNode(element.tipoCard))
    outrotd6.appendChild(document.createTextNode(element.colecaoCard))
    tr.appendChild(td)
    tr.appendChild(outrotd1)
    tr.appendChild(outrotd2)
    tr.appendChild(outrotd3)
    tr.appendChild(outrotd4)
    tr.appendChild(outrotd5)
    tr.appendChild(outrotd6)

    tbody.appendChild(tr)
    var apagador = document.createElement('input');
    apagador.type = "button";
    apagador.value = "apagador";
    apagador.onclick = function (e) {
      let keypath = e.path[1].cells[0].innerHTML;
      console.log(keypath);

      // dados = {
      //   id: $(this).data('id')
      // };

      $.ajax({
        url: "http://localhost:8080/colecao/" + keypath,
        type: "DELETE",
        dataType: 'JSON',
        // data: dados
      }).done(function (data) {
        console.log(data);

        // aqui você faz alguma ação para quando o ajax retornar
      });


    }
    tr.appendChild(apagador)
    tbody.appendChild(tr)
  }

  t.appendChild(tbody)
  table.appendChild(t)


});
