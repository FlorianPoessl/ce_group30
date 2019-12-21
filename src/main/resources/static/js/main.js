function goToCustomerButton () {
      console.log("Executing Button");
      window.open("customer", "_self");
};

function goToHandlebarButton () {
      console.log("Executing Button");
      window.open("handlebar", "_self");
};

function loadDataHandlebar () {
    var handlebars;
    $.ajax({
      type: "GET",
      url: "https://www.maripavi.at/produkt/lenkertyp",
      async: false,
      success: function (result) {
          console.log(result);
          handlebars = result;
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
}

function goToMaterialButton () {
      console.log("Executing Button");
      window.open("material", "_self");
       $.ajax({
          type: "GET",
          url: "http://www.maripavi.at/produkt/lenkertyp",
          data: {movieName: movieName, movieDate: movieDate, movieTime: movieTime},
          success: function (result) {
              console.log(result);
          },
          error: function (result) {
              console.log("Something went wrong");
          }
      });
};

function goToGearingButton () {
      console.log("Executing Button");
      window.open("gearing", "_self");
};

function goToHandleButton () {
      console.log("Executing Button");
      window.open("handle", "_self");
};

function goToOrderButton () {
      console.log("Executing Button");
      window.open("order", "_self");
};

