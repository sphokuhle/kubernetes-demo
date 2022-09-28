#!/bin/sh
psql --command "CREATE USER postgres WITH PASSWORD 'posPassword1';"
psql --command "CREATE DATABASE demodatabase;"
psql --command "GRANT ALL PRIVILEGES ON DATABASE demodatabase to postgres;"
psql --command "\q;"
exit