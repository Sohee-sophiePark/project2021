# import libraries

from typing import Sequence
import pandas as pd
import streamlit as st
import altair as alt # graphs in App
from PIL import Image # for Logo Image in App


# Page Title

img = Image.open('C:\\Users\\SophiePark\\Documents\\Git\\project2021\\project2021\\python-12-ds-apps\\simple_bioinfo_dna_count\\dna_img_from_pixabay.png')

st.image(img, use_column_width=True) #Allow the image to expand to the Width of Col

st.write("""
# DNS Nucleotide Count Web App by FreeCodeCamp
This app counts the nucleotide composition of query DNA!
***
""")
# *** horizontal line im MD
# Adenine / Guanine / Cytosine / Thymine - 4 types



# Input Text Box
st.header('Enter DNA Sequnce')
in_seq = st.text_input('', '>')
# in_seq = ">DNA Query 2\nGAACACGTGGAGGCAAACAGGAAGGTGAAGAAGAACTTATCCTATCAGGACGGAAGGTCCTGTGCTCGGG\nATCTTCCAGACGTCGCGACTCTAAATTGCCCCCTCTGAGGTCAAGGAACACAAGATGGTTTTGGAAATGC\nTGAACCCGATACATTATAACATCACCAGCATCGTGCCTGAAGCCATGCCTGCTGCCACCATGCCAGTCCT"

seq = st.text_area("Sequence Input", in_seq, height=250) #input text box with fixed height
# seq = seq.splitlineS()
# seq = seq[1:] #skip the first line
# seq = ''.join(seq) # concat list to string

st.write("""
***
""")

# Prints the Input DNA Sequence
st.header('Input (DNA Query)')
seq

# DNA Nucleotide Count
st.header('OUTPUT(DNA Query)')
