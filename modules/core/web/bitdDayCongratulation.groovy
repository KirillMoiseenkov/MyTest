String age = binding.getVariable("age")
String name = binding.getVariable("name")
String lastName = binding.getVariable("lastName")
String carService = binding.getVariable("carSerivce")

String message = "Поздравляем вас с днем рождения, уважаемый ${name}! \n" +
        "Желаем всего наилучшего в ваши ${age} лет! \n" +
        "С уважением, коллектив автосервиса \"${carSerivce}\"!"


return message;

