# Quick Notes (Android)

Простое Android-приложение на Java для быстрых заметок. Пользователь вводит текст и сохраняет его в списке. Заметки переживают поворот экрана и остаются в текущей сессии.

## Стек
- Java 17
- Android SDK 34 (minSdk 24)
- AndroidX AppCompat, Material 3, RecyclerView, ConstraintLayout
- View Binding

## Как запустить в Android Studio
1. Откройте Android Studio и выберите **File → Open…**.
2. Укажите папку `android-java-app` в этом репозитории и подтвердите импорт Gradle-проекта.
3. Дождитесь синхронизации Gradle.
4. Подключите устройство или запустите эмулятор.
5. Нажмите **Run ▶** (Shift+F10), выберите цель и дождитесь установки.

## Возможности
- Добавление заметок через кнопку или клавишу `Готово` на клавиатуре.
- Проверка на пустой ввод с подсказкой и Toast-сообщением.
- Сохранение списка заметок при повороте экрана.
- Современный интерфейс на базе компонентов Material.

## Структура проекта
- `app/src/main/java/com/example/quicknotes/MainActivity.java` — основной экран, работа с вводом и списком заметок.
- `app/src/main/java/com/example/quicknotes/NoteAdapter.java` — адаптер RecyclerView.
- `app/src/main/res/layout/activity_main.xml` — разметка экрана.
- `app/src/main/res/layout/item_note.xml` — карточка отдельной заметки.

При необходимости вы можете расширить проект: добавить сохранение в базу данных, поиск или напоминания.
