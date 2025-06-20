#!/bin/bash

cat <<EOF > /pgadmin4/servers.json
{
  "Servers": {
    "1": {
      "Name": "${SERVER_NAME}",
      "Group": "Servers",
      "Host": "${DATABASE_HOST}",
      "Port": ${DATABASE_PORT},
      "MaintenanceDB": "${DATABASE_NAME}",
      "Username": "${DATABASE_USER}",
      "Password": "${DATABASE_PASSWORD}",
      "SSLMode": "prefer"
    }
  }
}
EOF

exec /entrypoint.sh
