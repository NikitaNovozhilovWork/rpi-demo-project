function action(direction) {
    var url = "/action/move?direction=" + direction;
    $.ajax({
      type: "GET",
      url: url,
      success: function (messages) {
        console.log(direction)
      },
      error: function (e) {
        console.log('move direction error: ' + e);
      }
    });
}

function stop() {
    $.ajax({
      type: "GET",
      url: "/action/stop",
      success: function (messages) {
        console.log("Stop")
      },
      error: function (e) {
        console.log('move direction error: ' + e);
      }
    });
}

function updateDistance() {
  $.ajax({
    type: "GET",
    url: "/info/distance",
    success: function (messages) {
      var distance = messages / 10;
      var distancePercent = distance / 4;
      $( "#distance" ).attr("aria-valuenow", distancePercent);
      $( "#distance" ).css("width", distancePercent + "%");
      $( "#distance" ).text(distance + " cm");
    },
    error: function (e) {
      console.log('distance info error: ' + e);
    }
  });
}

$(document).ready(function () {
    $( "#UpButton" ).on("mousedown touchstart", function() { action("FORWARD"); });
    $( "#RightButton" ).on("mousedown touchstart", function() { action("RIGHT"); });
    $( "#LeftButton" ).on("mousedown touchstart", function() { action("LEFT"); });
    $( "#DownButton" ).on("mousedown touchstart", function() { action("BACKWARD"); });
    $( "#StopButton" ).click(function() { stop(); });
    $( "#UpButton" ).on("mouseup touchend", function() { stop(); });
    $( "#RightButton" ).on("mouseup touchend", function() { stop(); });
    $( "#LeftButton" ).on("mouseup touchend", function() { stop(); });
    $( "#DownButton" ).on("mouseup touchend", function() { stop(); });
    var intervalID = setInterval(updateDistance(), 5000);
});