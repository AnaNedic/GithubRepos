# GithubRepos

This is demo project that displays list of repositories fetched from a given url. Click on an item opens detailed view.
It uses Retrofit to fetch data, Gson to convert them and Glide to load images.

In the real-world scenario, next steps for development would be:
- add more tests
- use ViewModel class so that fetched data would survive configuration changes such as screen rotations
- add error view to display if fetching data failed (e.g. no network connection)
- adjust layouts according to the design provided by the designer (there are more details in Item class that are available for displaying)

Url used to fetch data from Github can easily be changed if it needed - in the class UrlsUtil.
