@Согласование

Feature: Согласование

  Scenario: Взаимодействия над чек-боксами

    * Клик на таск "Согласование Шахбазян"
#    Then проверка открытия формы
    * Клик на кнопку  "Согласовано"
#    And ввод комментария
    * Клик на кнопку  "Согласовано"
#    Then проверка появлением галочки

    * Клик на таск "Согласование ОДД"
#    Then проверка открытия формы
    * Клик на кнопку  "Согласовано"
#    And ввод комментария
    * Клик на кнопку  "Согласовано"
#    Then проверка появлением галочки

    * Клик на таск "Согласование МГТ"
#    Then проверка открытия формы
    * Клик на кнопку  "Согласовано"
#    And ввод комментария
    * Клик на кнопку  "Согласовано"
#    Then проверка появлением галочки

    * Клик на таск "Согласование АМПП"
#    Then проверка открытия формы
    * Клик на кнопку  "Согласовано"
#    And ввод комментария
    * Клик на кнопку  "Согласовано"
#    Then проверка появлением галочки

  Scenario: Создания пакета
    * Клик на кнопку "пакет"
#    Then проверка открытия формы
    * Клик на кнопку  "Сохранить"

    * проверка наличия созданной карточки пакет

    * Клик на таск  "Утверждение Ходаков"
    #    Then проверка открытия формы
    * Клик на кнопку  "Выполнено"
    * Клик на кнопку  "Выполнено"

    * Клик на таск  "Утверждение ДТ"
    * Клик на кнопку  "Выполнено"
    * ввод "Входящий номер" "1234567890"
#    And ввод "Исходящий номер" "1234567890"

    * Клик на кнопку  "Выполнено"


#    Then проверка наличия созданной карточки






