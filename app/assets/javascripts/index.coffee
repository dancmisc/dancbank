$ ->
  $.get "/accounts", (data) ->
    $.each data, (index, acc) ->
      $("#accounts").append $("<li>").text acc.name
