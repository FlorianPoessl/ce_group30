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
             async: false,
             success: function (result) {
                 console.log(result);
                 handlebars = JSON.parse(result);
             },
             error: function (result) {
                 console.log("Something went wrong");
             }
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
           async: false,
           success: function (result) {
               console.log(result);
               handlebars = JSON.parse(result);
           },
           error: function (result) {
               console.log("Something went wrong");
           }
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
      console.log("Executing Button");
      window.open("order", "_self");
};

function loadDataOrder() {
    var handlebars;
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/getOrder",
      async: false,
      success: function (result) {
          console.log(result);
          handlebars = JSON.parse(result);
      },
      error: function (result) {
          console.log("Something went wrong");
      }
    });
};

