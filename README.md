# List of facts data

This project displays list of data by getting data from shared preference, if data does not exists fetches from server.
Pull to refresh is implemented to update data from server

## App Architecture
This project uses MVVM(Model View ViewModel) with Clean architecture.
I have used Android provided `ViewModel` `LiveData` and for threading relied on `Coroutines`.
For webservice call, used Retrofit with Coroutine

## Local Storage
I have used SharedPreference to store response data as part of local caching

## External Libraries
    1. Retrofit for webservice call
    2. Glide for loading image from url in Imageview

## TODO
1. Implement Dependency Injection library like dagger so that unit test can be added.
2. Add unit tests