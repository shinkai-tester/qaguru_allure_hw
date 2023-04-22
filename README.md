# qaguru_allure_with_actions
1). Создайте ветку gh-pages в GitHub в вашем репозитории

2). Добавьте токен (Профиль-Settings-Developer Settings-Personal access tokens-Tokens) и настройте Actions, Pages в GitHub в Settings репозитория:

- Actions: General -> Read and write permissions;
- Pages: Branch -> выбрать gh-pages

3). Если появится ошибка при запуске workflow типа gradlew: Permission Denied, локально в репозитории введите команду `git update-index --chmod=+x gradlew`

И сделайте push изменений.
