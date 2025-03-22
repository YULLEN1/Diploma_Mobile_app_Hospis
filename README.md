# Дипломный проект профессии «Инженер по тестированию»
## Предварительные условия:
1. Установить и открыть Android Studio

```https://developer.android.com/studio```


2. Склонировать репозиторий

```https://github.com/YULLEN1/Diploma_Mobile_app_Hospis``` 


3. Установить приложение "Мобильный хоспис" на мобильное устройство.

4. Данные для авторизации:

* В поле "Логин" ввести: login2


* В поле "Пароль" ввести: password2
## Инструкция по запуску
1. Перейти в файл в для проверки тестирования:

```fmh_android_15_03_24/app/src/androidTest/java/ru/iteco/fmhandroid/ui```


2. В терминале выполнить команду:

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AuthorizationTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AllTests' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AboutTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```
## Документация

1. [План автоматизации тестирования](https://github.com/YULLEN1/Diploma_Mobile_app_Hospis/blob/main/Plan.md)
   
3. [Чек-лист](https://github.com/YULLEN1/Diploma_Mobile_app_Hospis/blob/main/Check.xlsx)

   
5. [Тест-кейсы](https://github.com/YULLEN1/Diploma_Mobile_app_Hospis/blob/main/Cases.xlsx)

   
7. [Отчёт о проведённом тестировании](https://github.com/YULLEN1/Diploma_Mobile_app_Hospis/blob/main/Result.md)
