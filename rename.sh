#!/bin/bash

# Define the backup extension and the search pattern
BACKUP_EXTENSION=".bak"
SEARCH_PATTERN="opencv"

# Check if the script is run with a directory argument
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <directory>"
    exit 1
fi

# Set the directory to search
SEARCH_DIR="$1"

# Check if the provided argument is a valid directory
if [ ! -d "$SEARCH_DIR" ]; then
    echo "Error: '$SEARCH_DIR' is not a valid directory."
    exit 1
fi

# Find files containing the search pattern and move them with .bak extension
find "$SEARCH_DIR" -type f -name "*$SEARCH_PATTERN*" | while read -r file; do
    # Define the new filename with .bak extension
    new_file="${file}.bak"
    
    # Move and rename the file
    echo "Moving '$file' to '$new_file'"
    mv "$file" "$new_file"
done

echo "Operation completed."
