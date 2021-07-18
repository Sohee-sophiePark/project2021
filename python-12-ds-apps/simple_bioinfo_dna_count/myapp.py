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
# in_seq = st.text_input('', '>') # can not recognize \n for a line

in_seq = ">DNA Query 2\nGAACACGTGGAGGCAAACAGGAAGGTGAAGAAGAACTTATCCTATCAGGACGGAAGGTCCTGTGCTCGGG\nATCTTCCAGACGTCGCGACTCTAAATTGCCCCCTCTGAGGTCAAGGAACACAAGATGGTTTTGGAAATGC\nTGAACCCGATACATTATAACATCACCAGCATCGTGCCTGAAGCCATGCCTGCTGCCACCATGCCAGTCCT"

seq = st.text_area("Sequence Input", in_seq, height=250) #input text box with fixed height
seq = in_seq.splitlines()

seq = seq[1:] #skip the first line
seq = ''.join(seq) # concat list to string

st.write("""
***
""")

# Prints the Input DNA Sequence
st.header('Input (DNA Query)')
seq
st.write("""
***
""")
# DNA Nucleotide Count
st.header('Output (DNA Nucleotide Count)')

st.subheader('1. Print Dictionary')
def DNA_nucleotide_count(seq):
    d = dict([
        ('A', seq.count('A')),
        ('T', seq.count('T')),
        ('G', seq.count('G')),
        ('C', seq.count('C'))
    ])

    return d

X = DNA_nucleotide_count(seq)
X_labels = list(X)
X_values = list(X.values())
X
st.subheader('2. Print Text')
st.write('There are ' + str((X['A'])) + ' Adenine (A)')
st.write('There are ' + str((X['T'])) + ' Thymine (T)')
st.write('There are ' + str((X['G'])) + ' Guanine (G)')
st.write('There are ' + str((X['C'])) + ' Cytosine (C)')


st.subheader('Display DataFrame')
df_dna = pd.DataFrame.from_dict(X, orient='index')
df_dna = df_dna.rename({0: 'count'}, axis='columns')
df = df_dna
df.reset_index(inplace=True)
df = df.rename(columns = {'index':'nucleotide'})
st.write(df)

st.subheader('4. Display Bar Chart')
p = alt.Chart(df).mark_bar().encode(
    x = 'nucleotide',
    y = 'count'
)

p = p.properties(
    width=alt.Step(80) # controls width of bar
)

st.write(p)
# p - same result



st.write("""
***
""")
