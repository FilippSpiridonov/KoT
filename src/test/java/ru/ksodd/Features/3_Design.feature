@Проектирование

Feature: Проектирование

  Scenario: Создание нового проектирования
    * Клик на кнопку "запрос"
#    Then проверка открытия формы
    * ввод  и выбор улицы "Тверская улица"
    * выбор типа "Актуализация"
    * выбор программы "Проект 1100 улиц"
    * ввод объем работ "1000"
    * ввод планируемых работ "Новый асфальт"
    * Загрузка  файлов " DGN"
    * Загрузка  файлов " Основание"
    * Загрузка  файлов " ТЗ"
    * Клик на чек-бокс провести натурные обследования
    * Клик на кнопку  " СОХРАНИТЬ "
    * проверка наличия созданной карточки

    #==============================================================

  Scenario: Взаимодействия над чек-боксами

    * Клик на таск "Префектура"
    * Клик на кнопку  "Выдать замечание"
#    And ввод комментария
    * Клик на кнопку  "Выдать замечание"
    * цикл
    * Клик на таск "Префектура"
    * Клик на кнопку  "Согласовано"
#    And ввод комментария
    * Клик на кнопку  "Согласовано"

#    When Клик на таск "ГИБДД"
#    And Клик на кнопку  "Выдать замечание"
##    And ввод комментария
#    And Клик на кнопку  "Выдать замечание"
#    When цикл
#    And Клик на кнопку  "Согласовано"
##    And ввод комментария
#    And Клик на кнопку  "Согласовано"

    * Клик на таск "Принять в работу"
#    Then проверка открытия формы
    * Клик на кнопку  "Принято"
#    And ввод комментария
    * Клик на кнопку  "Принято"
#    Then проверка появлением галочки
#
    * Клик на таск "Натурные обследования"
#    Then проверка открытия формы
    * Клик на кнопку  "Выполнено"
    * Загрузка   файлов "ФОТО*"
#    And ввод комментария
    * Клик на кнопку  "Выполнено"
#    Then проверка появлением галочки

    * Клик на таск "Запроектировать"
    * Клик на кнопку  "Выполнено"
#    And ввод комментария
    * Загрузка   файлов "DGN"
    * Загрузка   файлов "PDF"
#    And ввод комментария
    * Клик на кнопку  "Выполнено"












