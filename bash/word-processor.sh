#!/bin/bash

function verify {
    word=$1
    if [[ "$word" =~ ^[a-zA-Z]+$ ]]; then
        return 0
    else
        return 1
    fi
}

function to_lowercase {
    echo "$1" | tr 'A-Z' 'a-z'
}

if [ "$#" -le 0 ] || [ "$#" -gt 10 ]; then
    echo "La cantidad de argumentos debe estar entre 1 y 10." >&2
    exit 1
fi

words=("$@")

aux_words=()

for w in "${words[@]}"; do
    if verify "$w"; then
        words_lower=$(to_lowercase "$w")
        aux_words+=("$words_lower")
    fi
done

joining=$(IFS=' '; echo "${aux_words[*]}")

echo "$joining"