# CONTRIBUTING

## START WATCHER

Start a watcher in the background, which will recompile the script and hotload 
code whenever files are changed:

$ `docker-compose up -d watch`

Open a dashboard for the watcher from a web browser (if at first you fail, try again):

$ `open http://localhost:9630/dashboard`

## EXECUTE WITH HOTLOAD 

After verifying the watcher dashboard is enabled, execute the script, looping on 
code changes:

$ `docker-compose run script --help`

