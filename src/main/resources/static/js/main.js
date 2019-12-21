function goToCustomerButton () {
      console.log("Executing Button");
      window.open("customer", "_self");
};

function goToHandlebarButton () {
       var vorname = document.getElementById("customerName").value;
       var nachname = document.getElementById("customerSurname").value;
       var data = {vorname: vorname, nachname: nachname};
       $.ajax({
             type: "POST",
             url: "http://localhost:8080/newCustomer",
             data: data,
             async: false
         });
      console.log("Executing Button");
      window.open("handlebar", "_self");
};

function loadDataHandlebar () {
    var handlebars;
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getHandlebar",
      async: false,
      success: function (result) {
          console.log(result);
          handlebars = JSON.parse(result);
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });

    var select = document.getElementById("selectHandlebar")
    for(var i = 0; i < handlebars.length; i++) {
      var opt = handlebars[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      select.appendChild(el);
    }
};

function goToMaterialButton () {
      var select = document.getElementById("selectHandlebar");
      var text = select.options[select.selectedIndex].text;
      var data = {handlebar: text};
      $.ajax({
           type: "POST",
           url: "http://localhost:8080/addHandlebar",
           data: data,
           async: false
       });

      console.log("Executing Button");
      window.open("material", "_self");
};

function loadDataMaterial () {
    var materials;
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getMaterial",
      async: false,
      success: function (result) {
          console.log(result);
          materials = JSON.parse(result);
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });

    var select = document.getElementById("selectMaterial")
    for(var i = 0; i < materials.length; i++) {
      var opt = materials[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      select.appendChild(el);
    }
};

function goToGearingButton () {
      var select = document.getElementById("selectMaterial");
        var text = select.options[select.selectedIndex].text;
        var data = {material: text};
        $.ajax({
             type: "POST",
             url: "http://localhost:8080/addMaterial",
             data: data,
             async: false
         });

      console.log("Executing Button");
      window.open("gearing", "_self");
};

function loadDataGearing () {
    var gearings;
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getGearing",
      async: false,
      success: function (result) {
          console.log(result);
          gearings = JSON.parse(result);
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });

    var select = document.getElementById("selectGearing")
    for(var i = 0; i < gearings.length; i++) {
      var opt = gearings[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      select.appendChild(el);
    }
};

function goToHandleButton () {
      var select = document.getElementById("selectGearing");
      var text = select.options[select.selectedIndex].text;
      var data = {gearing: text};
      $.ajax({
           type: "POST",
           url: "http://localhost:8080/addGearing",
           data: data,
           async: false
       });

      console.log("Executing Button");
      window.open("handle", "_self");
};

function loadDataHandle () {
    var handles;
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getHandle",
      async: false,
      success: function (result) {
          console.log(result);
          handles = JSON.parse(result);
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });

    var select = document.getElementById("selectHandle")
    for(var i = 0; i < handles.length; i++) {
      var opt = handles[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      select.appendChild(el);
    }
};

function goToOrderButton () {
       var select = document.getElementById("selectHandle");
            var text = select.options[select.selectedIndex].text;
            var data = {handle: text};
            $.ajax({
                 type: "POST",
                 url: "http://localhost:8080/addHandle",
                 data: data,
                 async: false
             });

      console.log("Executing Button");
      window.open("order", "_self");
};

function loadDataOrder() {
    var handlebars;
    var vorname = document.getElementById("vorname");
    var nachname = document.getElementById("nachname");
    var lenkertyp = document.getElementById("lenkertyp");
    var material = document.getElementById("material");
    var schaltung = document.getElementById("schaltung");
    var griff = document.getElementById("griff");

    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getOrderInfo",
      async: false,
      success: function (result) {
          console.log(result);
          var info = JSON.parse(result);
          vorname.innerHTML = info.vorname;
          nachname.innerHTML = info.nachname;
          lenkertyp.innerHTML = info.bestellung.lenkertyp;
          material.innerHTML = info.bestellung.material;
          schaltung.innerHTML = info.bestellung.schaltung;
          griff.innerHTML = info.bestellung.griff;
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });
};

