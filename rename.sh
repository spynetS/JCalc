#!/bin/bash

# Define the backup extension and the search pattern
BACKUP_EXTENSION=".bak"
SEARCH_PATTERN="opencv"
BACKUP_DIR="bakup"

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

# Create the backup directory if it doesn't exist
mkdir -p "$SEARCH_DIR/$BACKUP_DIR"

# Find files and symbolic links containing the search pattern and move them with .bak extension
find "$SEARCH_DIR" \( -type f -o -type l \) -name "*$SEARCH_PATTERN*" | while read -r file; do
    # Define the new filename with .bak extension in the backup directory
    base_name=$(basename "$file")
    new_file="$SEARCH_DIR/$BACKUP_DIR/${base_name}${BACKUP_EXTENSION}"
    
    # Move and rename the file or link to the backup directory
    echo "Moving '$file' to '$new_file'"
    mv "$file" "$new_file"
done

echo "Operation completed."
