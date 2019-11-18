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

$(function () {
    $( "#UpButton" ).click(function() { action("FORWARD"); });
    $( "#RightButton" ).click(function() { action("RIGHT"); });
    $( "#LeftButton" ).click(function() { action("LEFT"); });
    $( "#DownButton" ).click(function() { action("BACKWARD"); });
    $( "#StopButton" ).click(function() { stop(); });
    $( "#UpButton" ).keyup(function() { stop(); });
    $( "#RightButton" ).keyup(function() { stop(); });
    $( "#LeftButton" ).keyup(function() { stop(); });
    $( "#DownButton" ).keyup(function() { stop(); });
});