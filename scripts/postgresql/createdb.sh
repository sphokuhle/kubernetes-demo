#!/bin/sh
#psql -U postgres -c "CREATE DATABASE demodb WITH ENCODING 'UTF8'"
psql --command "CREATE USER postgres WITH PASSWORD 'posPassword1';"
psql --command "CREATE DATABASE demodb;"
psql --command "GRANT ALL PRIVILEGES ON DATABASE demodb to postgres;"
psql --command "\q;"
exit